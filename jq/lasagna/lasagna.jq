# The input will be null or an object that _may_ contain keys
#   actual_minutes_in_oven,
#   number_of_layers
#
# If the needed key is missing, use a default value:
#   zero minutes in oven,
#   one layer.
#
# Task: output a JSON object with keys:

40 as $expected_minutes_in_oven | 
. as {$actual_minutes_in_oven, $number_of_layers} |
($expected_minutes_in_oven - ($actual_minutes_in_oven // 0)) as $remaining_minutes_in_oven | 
(($number_of_layers // 0) * 2) as $preparation_time | 
($preparation_time + $actual_minutes_in_oven) as $total_time |
{
  $expected_minutes_in_oven,
  $remaining_minutes_in_oven,
  $preparation_time,
  $total_time
}
