def convert(number: int) -> str:
    result = ''
    if not number % 3:
        result += 'Pling'
    if not number % 5:
        result += 'Plang'
    if not number % 7:
        result += 'Plong'

    return result or str(number)
