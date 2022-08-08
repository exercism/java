defmodule LasagnaTest do
  use ExUnit.Case
  doctest Lasagna

  @tag task_id: 1
  test "expected minutes in oven" do
    assert Lasagna.expected_minutes_in_oven() === 40
  end

  @tag task_id: 2
  test "remaining minutes in oven" do
    assert Lasagna.remaining_minutes_in_oven(25) === 15
  end

  @tag task_id: 3
  test "preparation time in minutes for one layer" do
    assert Lasagna.preparation_time_in_minutes(1) === 2
  end

  @tag task_id: 3
  test "preparation time in minutes for multiple layers" do
    assert Lasagna.preparation_time_in_minutes(4) === 8
  end

  @tag task_id: 4
  test "total time in minutes for one layer" do
    assert Lasagna.total_time_in_minutes(1, 30) === 32
  end

  @tag task_id: 4
  test "total time in minutes for multiple layers" do
    assert Lasagna.total_time_in_minutes(4, 8) === 16
  end

  @tag task_id: 5
  test "notification message" do
    assert Lasagna.alarm() === "Ding!"
  end
end
