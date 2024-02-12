def find_like_hay_all_tests(num_tests, all_tests):
    all_results = []
    
    for i in range(num_tests):
        ntest = all_tests[i][0]
        test = all_tests[i][1:]
        result = find_like_hay(ntest, test)
        all_results.append(result)
    
    return all_results


def find_like_in_three(hays):
    counter = {}
    ret = -1
    for h in hays:
        if h not in counter:
            counter[h] = 1
        else:
            counter[h] += 1
            ret = h
            break
    return ret
def find_like_hay(ncows, hays):
    rets = []
    hays_liked = [0]*ncows
    if ncows == 1:
        rets.append(-1)
    elif ncows == 2:
        if hays[0] == hays[1]:
            rets.append(hays[0])
        else:
            rets.append(-1)
    else:
       
        for i in range(ncows-2):
            
            most_like = find_like_in_three(hays[i:i+3])
            if most_like == -1:
                pass
            else:
                hays_liked[most_like-1] = 1
       
        for i in range(ncows):
            if hays_liked[i] == 1:
                rets.append(i+1)
        if len(rets) == 0:
            rets = [-1]
    return rets

if __name__ == "__main__":
    num_tests = int(input())
    all_tests = []

    for _ in range(num_tests):
        ntest = int(input())
        test = list(map(int, input().split()))
        all_tests.append([ntest] + test)

    results = find_like_hay_all_tests(num_tests, all_tests)
    
    for result in results:
        if type(result) == list:
            print(*result)
        else:
            print(result)
