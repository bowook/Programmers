def solution(wallpaper):
    row, column = [], []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                row.append(i)
                column.append(j)
    return [min(row), min(column), max(row) + 1, max(column) + 1]