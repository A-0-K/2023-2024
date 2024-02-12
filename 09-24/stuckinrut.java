import java.util.*;
import java.io.*;
public class stuckinrut {
    public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine()); // # of cows
		
		Cow[] cows = new Cow[n];
		for(int j=0;j<n;j++) { // take in input of cows
			StringTokenizer st = new StringTokenizer(in.readLine());
			boolean dir=false;
			if(st.nextToken().equals("E")) {
				dir=true;
			}
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
			cows[j]=new Cow(x,y,dir);
		}
		// make list of meetpoints
		ArrayList<Meeting> meetpoints = new ArrayList<>();
		for(int j=0;j<n;j++) {
			for(int k=j+1;k<n;k++) { // combine cows[j] and cows[k]
				// if they meet, create a Meeting and add it to meetpoints
				if(cows[j].direction==true) {
					if(cows[k].direction==true) { // cows[j] and cows[k] both east
						if(cows[j].y==cows[k].y) {
							if(cows[j].x<cows[k].x) { // cows[j] stopped
								Meeting m = new Meeting(cows[k],cows[j],cows[k].x-cows[j].x);
								meetpoints.add(m);
							}
							else { // cows[k] stopped
								Meeting m = new Meeting(cows[j],cows[k],cows[j].x-cows[k].x);
								meetpoints.add(m);
							}
						}
					}
					else { // cows[j] east, cows[k] north
						long eTravel=cows[k].x-cows[j].x; // distance cow moving east travels
						if(eTravel>=0) { // only if eTravel distance valid
							long nTravel=cows[j].y-cows[k].y;
							if(nTravel>=0&&nTravel!=eTravel) { // only if nTravel distance valid and the cows wont just pass each other
								if(eTravel>nTravel) { // cow moving east is stopped
									Meeting m = new Meeting(cows[k],cows[j],eTravel);
									meetpoints.add(m);
								}
								else { // cow moving north stopped
									Meeting m = new Meeting(cows[j],cows[k],nTravel);
									meetpoints.add(m);
								}
							}
						}
					}
				}
				else {
					if(cows[k].direction==true) { // cows[j] north cows[k] east
						long eTravel=cows[j].x-cows[k].x; // distance cow moving east travels
						if(eTravel>=0) { // only if eTravel distance valid
							long nTravel=cows[k].y-cows[j].y;
							if(nTravel>=0&&nTravel!=eTravel) { // only if nTravel distance valid and the cows wont just pass each other
								if(eTravel>nTravel) { // cow moving east is stopped
									Meeting m = new Meeting(cows[j],cows[k],eTravel);
									meetpoints.add(m);
								}
								else { // cow moving north stopped
									Meeting m = new Meeting(cows[k],cows[j],nTravel);
									meetpoints.add(m);
								}
							}
						}
					}
					else { // cows[j] north cows[k] north
						if(cows[j].x==cows[k].x) {
							if(cows[j].y<cows[k].y) { // cows[j] stopped
								Meeting m = new Meeting(cows[k],cows[j],cows[k].y-cows[j].y);
								meetpoints.add(m);
							}
							else { // cows[k] stopped
								Meeting m = new Meeting(cows[j],cows[k],cows[j].y-cows[k].y);
								meetpoints.add(m);
							}
						}
					}
				}
			}
		}
		Collections.sort(meetpoints, (a,b)->(int)(a.t-b.t));
		// iterate thru meets and see who stops who
		for(Meeting meet:meetpoints) {
			// if one of the cows meeting have already stopped ignore this meetpoint
			if(meet.blamed.stopped || meet.stopped.stopped)continue;
			// otherwise process blamed and stopped
			meet.stopped.stopped=true;
			meet.blamed.blame+=meet.stopped.blame+1;
		}
		for(int j=0;j<n;j++) {
			out.println(cows[j].blame);
		}

		in.close();
		out.close();
	}
}


class Cow {
	public Cow(long xx, long yy, boolean dir) {
		x=xx; // starting x coord
		y=yy;
		blame=0;
		direction=dir;
		stopped=false;
	}
	public boolean direction; // true=east, false=north
	public long x;
	public long y;
	public long blame;
	public boolean stopped;
}

class Meeting{
	public Meeting(Cow b, Cow s, long tt) {
		blamed=b;
		stopped=s;
		t=tt;
	}
	public Cow blamed; // cow blamed / cow who stopped other cow
	public Cow stopped; // cow who was stopped
	public long t; // time of meeting
}
