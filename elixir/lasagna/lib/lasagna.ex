defmodule Lasagna do
  def expected_minutes_in_oven do
    40
  end

  def remaining_minutes_in_oven(minutes_in_oven) do
    expected_minutes_in_oven() - minutes_in_oven
  end

  def preparation_time_in_minutes(layers) do
    2 * layers
  end

  def total_time_in_minutes(layers, minutes_in_oven) do
    preparation_time_in_minutes(layers) +
      (expected_minutes_in_oven() - remaining_minutes_in_oven(minutes_in_oven))
  end

  def alarm do
    "Ding!"
  end
end
