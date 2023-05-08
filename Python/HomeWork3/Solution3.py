# Игра «Scrabble». В настольной игре Скрабл (Scrabble) каждая буква имеет определенную ценность. В случае с английским алфавитом очки распределяются так:

# A, E, I, O, U, L, N, S, T, R || А, В, Е, И, Н, О, Р, С, Т– 1 очко;

# D, G || Д, К, Л, М, П, У – 2 очка;

# B, C, M, P || Б, Г, Ё, Ь, Я – 3 очка;

# F, H, V, W, Y || Й, Ы – 4 очка;

# K || Ж, З, Х, Ц, Ч – 5 очков;

# J, X || Ш, Э, Ю – 8 очков;

# Q, Z || Ф, Щ, Ъ – 10 очков.

# import re

# word = input('Введите слово ').upper()
# dct = {
#     "[AEIOULNSTRАВЕИНОРСТ]": "1",
#     "[DGДКЛМПУ]": "2",
#     "[BCMPБГЁЬЯ]": "3",
#     "[FHVWYЙЫ]": "4",
#     "[KЖЗХЦЧ]": "5",
#     "[JXШЭЮ]": "8",
#     "[QZФЩЪ]": "10",
# }
# for key in dct:
#     word = re.sub(key, dct[key], word)
# print(sum(map(int, word)))

# word = input('Введите слово ').upper()
# dct = {
#     "[AEIOULNSTRАВЕИНОРСТ]": 1,
#     "[DGДКЛМПУ]": 2,
#     "[BCMPБГЁЬЯ]": 3,
#     "[FHVWYЙЫ]": 4,
#     "[KЖЗХЦЧ]": 5,
#     "[JXШЭЮ]": 8,
#     "[QZФЩЪ]": 10,
# }
# list = list(word)
# print(list)
# count= 0
# for letter in word:
#     for key, value in dct.items():
#         if letter in key:
#             count = count + value
# print (count)


word = input('Введите слово ').upper()
dct = {
    "[AEIOULNSTRАВЕИНОРСТ]": 1,
    "[DGДКЛМПУ]": 2,
    "[BCMPБГЁЬЯ]": 3,
    "[FHVWYЙЫ]": 4,
    "[KЖЗХЦЧ]": 5,
    "[JXШЭЮ]": 8,
    "[QZФЩЪ]": 10,
}
list = list(word)
print(list)

print(sum([value for i in word for key, value in dct.items() if i in key]))