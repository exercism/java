def is_armstrong_number(number: int) -> bool:
    number_str = str(number)
    ndigits = len(number_str)
    expsum = sum((int(x)**ndigits for x in number_str))
    return expsum == number
