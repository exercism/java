import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DotDslTest {

    @Test
    public void testEmptyGraph() {
        Graph g = new Graph(new Object[][]{});

        assertEquals(g.nodes, emptyList());
        assertEquals(g.edges, emptyList());
        assertEquals(g.attrs, emptyMap());
    }

    @Ignore("Remove to run test")
    @Test
    public void testGraphWithOneNode() {
        Graph g = new Graph(new Object[][]{
                {Type.NODE, "a", emptyMap()}
        });

        assertEquals(g.nodes, singletonList(new Node("a", emptyMap())));
        assertEquals(g.edges, emptyList());
        assertEquals(g.attrs, emptyMap());
    }

    @Ignore("Remove to run test")
    @Test
    public void testGraphWithOneNodeWithKeywords() {
        Graph g = new Graph(new Object[][]{
                {Type.NODE, "a", singletonMap("color", "green")}
        });

        assertEquals(g.nodes, singletonList(new Node("a", singletonMap("color", "green"))));
        assertEquals(g.edges, emptyList());
        assertEquals(g.attrs, emptyMap());
    }

    @Ignore("Remove to run test")
    @Test
    public void testGraphWithOneEdge() {
        Graph g = new Graph(new Object[][]{
                {Type.EDGE, "a", "b", emptyMap()}
        });

        assertEquals(g.nodes, emptyList());
        assertEquals(g.edges, singletonList(new Edge("a", "b", emptyMap())));
        assertEquals(g.attrs, emptyMap());
    }

    @Ignore("Remove to run test")
    @Test
    public void testGraphWithOneAttribute() {
        Graph g = new Graph(new Object[][]{
                {Type.ATTR, "foo", "1"}
        });

        assertEquals(g.nodes, emptyList());
        assertEquals(g.edges, emptyList());
        assertEquals(g.attrs, singletonMap("foo", "1"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testGraphWithAttributes() {
        Graph g = new Graph(new Object[][]{
                {Type.ATTR, "foo", "1"},
                {Type.ATTR, "title", "Testing Attrs"},
                {Type.NODE, "a", singletonMap("color", "green")},
                {Type.NODE, "c", emptyMap()},
                {Type.NODE, "b", singletonMap("label", "Beta!")},
                {Type.EDGE, "b", "c", emptyMap()},
                {Type.EDGE, "a", "b", singletonMap("color", "blue")},
                {Type.ATTR, "bar", "true"}
        });

        assertEquals(g.nodes, Arrays.asList(
                new Node("a", singletonMap("color", "green")),
                new Node("c", emptyMap()),
                new Node("b", singletonMap("label", "Beta!"))
        ));
        assertEquals(g.edges, Arrays.asList(
                new Edge("b", "c", emptyMap()),
                new Edge("a", "b", singletonMap("color", "blue"))
        ));
        assertEquals(g.attrs, Stream.of(new String[][]{
                {"foo", "1"},
                {"title", "Testing Attrs"},
                {"bar", "true"}
        }).collect(Collectors.toMap(item -> item[0], item -> item[1])));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMalformedGraph() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{1}})
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{"problematic"}})
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testMalformedGraphItem() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{}})
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{Type.ATTR}})
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testMalformedAttr() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{Type.ATTR, 1, 2, 3}})
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testMalformedNode() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{Type.NODE, 1, 2, 3}})
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testMalformedEdge() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{Type.EDGE, 1, 2}})
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnknownItem() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Graph(new Object[][]{{99, 1, 2}})
        );
    }
}
