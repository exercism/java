// Include the test framework.
#include "vendor/unity.h"

// Include the header file with the declarations of the functions you create.
#include "../src/hello_world.h"

// Runs before every test.
void setUp(void)
{
}

// Runs after every test.
void tearDown(void)
{
}

// Defines a single test.
static void test_say_hi(void)
{
   // Check if the 'hello()' function returns "Hello, World!"
   // This test is expected to fail after first downloading this exercise.
   // To make this test pass, fix the 'hello()' function definition in the
   // source file src/hello_world.c.
   TEST_ASSERT_EQUAL_STRING("Hello, World!", hello());
}

// Runs the test(s)
int main(void)
{
   UnityBegin("test/test_hello_world.c");

   RUN_TEST(test_say_hi);

   return UnityEnd();
}
