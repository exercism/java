# Note, the expressions for the first three tasks must end with commas.
#
# Recall that a jq program is a *single expression*. For this exercise,
# you are solving four separate tasks with one source file. Use the
# comma operator so the outputs of these filters are joined into a
# single output stream. jq prints each item in a data stream on a
# separate line, which makes the tests easier to write.
#
# This is an error:
#     jq -n '
#       1
#       2
#       3
#     '
#  
# With commas, it is OK:
#     jq -n '
#       1,
#       2,
#       3
#     '
# 

# Task 1: replace `null` with the appropriate expression
.name,

# Task 2: replace `null` with the appropriate expression
(.ingredients | length),

# Task 3: replace `null` with the appropriate expression
(.ingredients | map(select(.item == "sugar")) | map(.amount.quantity) | add),

# Task 4: replace `null` with the appropriate expression
# (no comma after the last filter)
(.ingredients + .["optional ingredients"] | map(select(has("substitute"))) | map({(.item): .substitute }) | add)
