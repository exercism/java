def is_armstrong_number(number):
    number_str = str(number)
    ndigits = len(number_str)
    expsum = sum(map(lambda x: int(x)**ndigits, number_str))
    return expsum == number
