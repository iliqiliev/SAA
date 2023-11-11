def main():
    # the buildings count is useless so we ignore it
    transmitter_range = int(input().split()[1])
    buildings_positions = {int(position) for position in input().split()}

    buildings_map: list[None | bool] = [None] * (max(buildings_positions) + 1)

    # None means empty space, bool indicates if there is a radio transmitter
    for position in buildings_positions:
        buildings_map[position] = False

    del buildings_positions

    index = 0
    while index < len(buildings_map) and transmitter_range >= 0:
        # check if there is a building
        if buildings_map[index] is False:
            next_index = index + transmitter_range

            # check if the next transmitter position is a valid
            while next_index >= len(buildings_map) or buildings_map[next_index] is None:
                next_index -= 1

            # put the transmitter
            buildings_map[next_index] = True

            # advance the position to the last building
            # covered by the transmitter above
            index += transmitter_range * 2

        # advance the loop
        index += 1

    print(sum(1 for transmitter in buildings_map if transmitter))


if __name__ == "__main__":
    main()
