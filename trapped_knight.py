def fill_spiral_array(size):
    # Initialize a 2D array with zeros
    board = [[0] * size for _ in range(size)]
    center = size // 2

    # Begin at the center of the board
    x, y = center, center
    num = 1
    max_num = size * size
    board[x][y] = num
    num += 1

    # directions: right, down, left, up
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    steps = 1

    while num <= max_num:
        for i, (dx, dy) in enumerate(directions):
            for _ in range(steps):
                x += dx
                y += dy
                if 0 <= x < size and 0 <= y < size:
                    board[x][y] = num
                    num += 1
                if num > max_num:
                    break
            if num > max_num:
                break
            # Add an extra step after the right (0) or left (2) move
            if i == 1 or i == 3:
                steps += 1

    return board

def possible_knight_moves(x, y):
    return [
        (x + 2, y + 1), (x + 2, y - 1), (x - 2, y + 1), (x - 2, y - 1),
        (x + 1, y + 2), (x + 1, y - 2), (x - 1, y + 2), (x - 1, y - 2)
    ]

def print_board(board, visited=None):
    if visited is None:
        visited = set()
    for i, row in enumerate(board):
        line = []
        for j, num in enumerate(row):
            if (i, j) in visited:
                line.append(f"[{num:2}]")
            else:
                line.append(f" {num:2} ")
        print(" ".join(line))
    print("\n")

def knight_tour(board):
    size = len(board)
    visited = set()
    x, y = size // 2, size // 2  # Start at the center of the board for odd sizes
    step = 0

    visited.add((x, y))
    print(f"Step {step}: Starting at ({x}, {y}) - Board Number: {board[x][y]}")
    print_board(board, visited)

    while True:
        min_value = float('inf')
        next_move = None

        for move in possible_knight_moves(x, y):
            nx, ny = move

            if 0 <= nx < size and 0 <= ny < size and (nx, ny) not in visited:
                val = board[nx][ny]
                if val < min_value:
                    min_value = val
                    next_move = (nx, ny)

        if next_move is None:
            print("The knight is trapped after", step, "steps.")
            break

        x, y = next_move
        visited.add(next_move)
        step += 1
        print(f"Step {step}: Moved to ({x}, {y}) - Board Number: {board[x][y]}")
        print_board(board, visited)

def main():
    length = 7  # Define the size of the board (7x7 for your example)
    spiral_board = fill_spiral_array(length)
    print("Initial Board:")
    print_board(spiral_board)
    knight_tour(spiral_board)

if __name__ == "__main__":
    main()