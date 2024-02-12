def jump_game(nstart_location, nlocations, locations):
    targets = {}
    for i in range(nlocations):
        if locations[i][0] == 1:
            targets[i] = 1

    targets_broken = []
    stop_jump = False

    current_location = nstart_location - 1
    current_power = 1
    njump = 0
    forward = 1
    jump_locations = []
    nwithout_target = 0

    while not stop_jump:
        njump += 1
        if locations[current_location][0] == 1:
            if targets[current_location] == 1 and current_power >= locations[current_location][1]:
                targets[current_location] = 0
                targets_broken.append(current_location)
                nwithout_target = 0
            else:
                nwithout_target += 1

            if forward:
                current_location = current_location + forward * current_power

            if outside_boundary(current_location, nlocations):
                stop_jump = True
                break

        else:
            nwithout_target += 1
            current_power += locations[current_location][1]
            forward = -1 * forward
            current_location += forward * current_power
            if outside_boundary(current_location, nlocations):
                stop_jump = True
                break
        jump_locations.append(current_location)

        if nwithout_target >= 5 * nlocations:
            stop_jump = True
            break
    return len(targets_broken)


def outside_boundary(location, nlocations):
    return location < 0 or location >= nlocations


if __name__ == "__main__":
    n, start_location = map(int, input().split())
    locations = [list(map(int, input().split())) for _ in range(n)]

    result = jump_game(start_location, n, locations)
    print(result)
