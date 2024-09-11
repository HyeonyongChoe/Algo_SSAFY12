numpc = int(input())
numcon = int(input())

lista = [[0]*(numpc+1) for _ in range(numpc+1)]

for i in range(numcon):
    start, end = map(int, input().split())
    lista[start][end] = 1
    lista[end][start] = 1

visted = []

def dfs_f(n):
    if n not in visted:
        visted.append(n)
        for i in range(1, numpc+1):
            if lista[n][i] and i not in visted:
                dfs_f(i)

dfs_f(1)

print(len(visted)-1)
