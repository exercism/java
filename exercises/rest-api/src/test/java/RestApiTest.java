import static org.junit.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RestApiTest {

    public static class UserManagementTest {
        @Test
        public void noUsers() {
            String expected =
                new JSONObject().put("users", new JSONArray()).toString();
            String url = "/users";

            assertEquals(expected, new RestApi().get(url));
        }

        @Ignore("Remove to run test")
        @Test
        public void addUser() {
            String expected = new JSONObject()
                .put("name", "Adam")
                .put("owes", new JSONObject())
                .put("owedBy", new JSONObject())
                .put("balance", 0.0)
                .toString();
            String url = "/add";
            JSONObject payload = new JSONObject().put("user", "Adam");

            assertEquals(expected, new RestApi().post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void getSingleUser() {
            String expected = new JSONObject()
                .put(
                    "users",
                    new JSONArray()
                        .put(
                            new JSONObject()
                            .put("name", "Bob")
                            .put("owes", new JSONObject())
                            .put("owedBy", new JSONObject())
                            .put("balance", 0.0)))
                .toString();
            String url = "/users";
            JSONObject payload =
                new JSONObject().put("users", new JSONArray().put("Bob"));

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").build(),
                    User.builder().setName("Bob").build())
                    .get(url, payload));
        }
    }

    public static class IouTest {
        @Test
        public void bothUsersHave0Balance() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put("owes", new JSONObject())
                                    .put(
                                        "owedBy",
                                        new JSONObject().put("Bob", 3.0))
                                    .put("balance", 3.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put(
                                        "owes",
                                        new JSONObject().put("Adam", 3.0))
                                    .put("owedBy", new JSONObject())
                                    .put("balance", -3.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Adam")
                    .put("borrower", "Bob")
                    .put("amount", 3.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").build(),
                    User.builder().setName("Bob").build())
                    .post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void borrowerHasNegativeBalance() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put("owes", new JSONObject())
                                    .put(
                                        "owedBy",
                                        new JSONObject().put("Bob", 3.0))
                                    .put("balance", 3.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put(
                                        "owes",
                                        new JSONObject()
                                            .put("Adam", 3.0)
                                            .put("Chuck", 3.0))
                                    .put("owedBy", new JSONObject())
                                    .put("balance", -6.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Adam")
                    .put("borrower", "Bob")
                    .put("amount", 3.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").build(),
                    User.builder().setName("Bob").owes("Chuck", 3.0).build(),
                    User.builder().setName("Chuck").owedBy("Bob", 3.0).build())
                    .post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void lenderHasNegativeBalance() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put(
                                        "owes",
                                        new JSONObject().put("Bob", 3.0))
                                    .put(
                                        "owedBy", new JSONObject())
                                    .put("balance", -3.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put(
                                        "owes",
                                        new JSONObject()
                                            .put("Chuck", 3.0))
                                    .put(
                                        "owedBy",
                                        new JSONObject().put("Adam", 3.0))
                                    .put("balance", 0.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Bob")
                    .put("borrower", "Adam")
                    .put("amount", 3.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").build(),
                    User.builder().setName("Bob").owes("Chuck", 3.0).build(),
                    User.builder().setName("Chuck").owedBy("Bob", 3.0).build())
                    .post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void lenderOwesBorrower() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put(
                                        "owes",
                                        new JSONObject().put("Bob", 1.0))
                                    .put("owedBy", new JSONObject())
                                    .put("balance", -1.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put("owes", new JSONObject())
                                    .put(
                                        "owedBy",
                                        new JSONObject().put("Adam", 1.0))
                                    .put("balance", 1.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Adam")
                    .put("borrower", "Bob")
                    .put("amount", 2.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").owes("Bob", 3.0).build(),
                    User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                    .post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void lenderOwesBorrowerLessThanNewLoan() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put("owes", new JSONObject())
                                    .put(
                                        "owedBy",
                                        new JSONObject().put("Bob", 1.0))
                                    .put("balance", 1.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put(
                                        "owes",
                                        new JSONObject().put("Adam", 1.0))
                                    .put("owedBy", new JSONObject())
                                    .put("balance", -1.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Adam")
                    .put("borrower", "Bob")
                    .put("amount", 4.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").owes("Bob", 3.0).build(),
                    User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                    .post(url, payload));
        }

        @Ignore("Remove to run test")
        @Test
        public void lenderOwesBorrowerSameAsNewLoan() {
            String expected =
                new JSONObject()
                    .put(
                        "users",
                        new JSONArray()
                            .put(
                                new JSONObject()
                                    .put("name", "Adam")
                                    .put("owes", new JSONObject())
                                    .put("owedBy", new JSONObject())
                                    .put("balance", 0.0))
                            .put(
                                new JSONObject()
                                    .put("name", "Bob")
                                    .put("owes", new JSONObject())
                                    .put("owedBy", new JSONObject())
                                    .put("balance", 0.0)))
                    .toString();
            String url = "/iou";
            JSONObject payload =
                new JSONObject()
                    .put("lender", "Adam")
                    .put("borrower", "Bob")
                    .put("amount", 3.0);

            assertEquals(
                expected,
                new RestApi(
                    User.builder().setName("Adam").owes("Bob", 3.0).build(),
                    User.builder().setName("Bob").owedBy("Adam", 3.0).build())
                    .post(url, payload));
        }
    }
}
