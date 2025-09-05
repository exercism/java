import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RelativeDistanceTest {

    @Test
    @DisplayName("Direct parent-child relation")
    public void testDirectParentChildRelation() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Vera", List.of("Tomoko"));
                put("Tomoko", List.of("Aditi"));
            }
        };

        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Vera", "Tomoko")).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Sibling relationship")
    public void testSiblingRelationship() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Dalia", List.of("Olga", "Yassin"));
            }
        };

        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Olga", "Yassin")).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Two degrees of separation, grandchild")
    public void testTwoDegreesOfSeparationGrandchild() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Khadija", List.of("Mateo"));
                put("Mateo", List.of("Rami"));
            }
        };

        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Khadija", "Rami")).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Unrelated individuals")
    public void testUnrelatedIndividuals() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Priya", List.of("Rami"));
                put("Kaito", List.of("Elif"));
            }
        };

        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Priya", "Kaito")).isEqualTo(-1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Complex graph, cousins")
    public void testComplexGraphCousins() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia", "Elias"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Elias", List.of("Javier"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };

        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Dimitri", "Fabio")).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Complex graph, no shortcut, far removed nephew")
    public void testComplexGraphNoShortcutFarRemovedNephew() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia", "Elias"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Elias", List.of("Javier"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };
        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Lucia", "Jun")).isEqualTo(14);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName(
            "Complex graph, some shortcuts, cross-down and cross-up, " +
                    "cousins several times removed, with unrelated family tree"
    )
    public void testComplexGraphSomeShortcutsCrossDownAndCrossUpCousinsSeveralTimesRemovedWithUnrelatedFamilyTree() {
        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };
        RelativeDistance rd = new RelativeDistance(familyTree);
        assertThat(rd.degreeOfSeparation("Wyatt", "Xia")).isEqualTo(12);
    }
}
