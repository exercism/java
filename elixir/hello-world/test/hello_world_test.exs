defmodule HelloWorldTest do
  use ExUnit.Case

  test "says 'Hello, World!'" do
    assert HelloWorld.hello() == "Hello, World!"
  end
end
