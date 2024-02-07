import math


def do_sim(n: int, factor: float) -> None:
    field_size = len(str(n))
    alloc = 1
    used = 0
    copies = 0
    resize_count = 0
    do_print = False
    for i in range(n):
        if used == alloc:
            # Copying the existing data involves `alloc` copies
            copies += alloc
            # We don't have enough space, so realloc the array
            alloc = math.ceil(alloc * factor)
            resize_count += 1
            # We do want to print this out
            do_print = True
        # We're using one more slot, and that involves one more copy.
        used += 1
        copies += 1
        if do_print:
            print(f"{used:{field_size}} / {alloc:{field_size+1}} - {copies:{field_size+2}} ({copies/used:.2f})")
            do_print = False
    print(f"# resizes: {resize_count}")


def main():
    lg_n = int(input("lg(N): "))
    factor = float(input("Resize factor: "))
    do_sim(2 ** lg_n + 1, factor)


if __name__ == "__main__":
    main()
