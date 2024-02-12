def make_healthy(npatch, bacteria_levels):
    napplications = 0
    for i in range(npatch - 1):
        napplications += abs(bacteria_levels[i])
        for j in range(i + 1, npatch):
            bacteria_levels[j] -= (j - i + 1) * bacteria_levels[i]
    napplications += abs(bacteria_levels[-1])
    return napplications


if __name__ == "__main__":
    npatch = int(input())
    bacteria_levels = list(map(int, input().split()))

    result = make_healthy(npatch, bacteria_levels)
    print(result)
