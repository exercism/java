EXPECTED_BAKE_TIME = 40

PREPARATION_TIME = 2


def bake_time_remaining(elapsed_bake_time):
    '''
    :param elapsed_bake_time: int baking time already elapsed
    :return: int remaining bake time derived from 'EXPECTED_BAKE_TIME'

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    '''

    return EXPECTED_BAKE_TIME - elapsed_bake_time


def preparation_time_in_minutes(layers):
    '''
    :param layers: int number of layers
    :return: int preparation time in minutes

    Function that takes the number of layers and returns the total minutes of preparation
    '''
    return PREPARATION_TIME * layers


def elapsed_time_in_minutes(number_of_layers, elapsed_bake_time):
    '''
    :param number_of_layers: int number of layers
    :param elapsed_bake_time: int elapsed time already
    :return: int elapsed time in minutes

    Function that takes the number of layers and the elapsed time and returns the total elapsed time
    '''
    return preparation_time_in_minutes(number_of_layers) + elapsed_bake_time
