def convert(number):
    drops = ''
    drops += 'Pling' if number % 3 == 0 else ''
    drops += 'Plang' if number % 5 == 0 else ''
    drops += 'Plong' if number % 7 == 0 else ''
    return drops or str(number)


