def coverage(buildings_map: list[None | bool], transmitter_range: int) -> int:
    transmitter_count = 0
    index = 0

    # don't solve for empty map or if the transmitter range is negative
    while index < len(buildings_map) and transmitter_range >= 0:
        # check if there is a building
        if buildings_map[index] is False:
            proposed_transmitter_position = index + transmitter_range

            # check if the next transmitter position is a valid
            while (
                proposed_transmitter_position >= len(buildings_map)
                or buildings_map[proposed_transmitter_position] is None
            ):
                # if it is not decrement it
                proposed_transmitter_position -= 1

            # put the transmitter
            buildings_map[proposed_transmitter_position] = True

            # set the index to the last building covered by the transmitter put above
            index = proposed_transmitter_position + transmitter_range

            # increase the transmitter count
            transmitter_count += 1

        # advance the loop
        index += 1

    return transmitter_count


def main():
    # the buildings count at [0] is useless so we ignore it
    transmitter_range = int(input().split()[1])
    building_positions = {int(position) for position in input().split()}

    # (+ 1) to include the 0th index
    buildings_map: list[None | bool] = [None] * (max(building_positions) + 1)

    # None means empty space, bool indicates if there is a radio transmitter
    for position in building_positions:
        buildings_map[position] = False

    print(coverage(buildings_map, transmitter_range))


if __name__ == "__main__":
    main()
