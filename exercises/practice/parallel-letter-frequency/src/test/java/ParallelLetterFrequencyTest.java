import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ParallelLetterFrequencyTest {

    private String calculateFrecuencies = 
        "There, peeping among the cloud-wrack above a dark tower high up in the mountains," +
        "Sam saw a white star twinkle for a while." +
        "The beauty of it smote his heart," +
        "as he looked up out of the forsaken land," +
        "and hope returned to him. For like a shaft," + 
        "clear and cold, the thought pierced him that in the end," +
        "the shadow was only a small and passing thing: there was light and high beauty forever beyond its reach.";
    
    private String largeTexts1 =
        "I am a sick man.... I am a spiteful man. I am an unattractive man.\n" +
        "I believe my liver is diseased. However, I know nothing at all about my disease, and do not\n" +
        "know for certain what ails me. I don't consult a doctor for it,\n" + 
        "and never have, though I have a respect for medicine and doctors.\n" + 
        "Besides, I am extremely superstitious, sufficiently so to respect medicine,\n" +
        "anyway (I am well-educated enough not to be superstitious, but I am superstitious).\n" +
        "No, I refuse to consult a doctor from spite.\n" +
        "That you probably will not understand. Well, I understand it, though.\n" +
        "Of course, I can't explain who it is precisely that I am mortifying in this case by my spite:\n" + 
        "I am perfectly well aware that I cannot \"pay out\" the doctors by not consulting them;\n" +
        "I know better than anyone that by all this I am only injuring myself and no one else.\n" + 
        "But still, if I don't consult a doctor it is from spite.\n" +
        "My liver is bad, well - let it get worse!\n" +
        "I have been going on like that for a long time - twenty years. Now I am forty.\n" +
        "I used to be in the government service, but am no longer.\n" +
        "I was a spiteful official. I was rude and took pleasure in being so.\n" +
        "I did not take bribes, you see, so I was bound to find a recompense in that, at least.\n" +
        "(A poor jest, but I will not scratch it out. I wrote it thinking it would sound very witty;\n" +
        "but now that I have seen myself that I only wanted to show off in a despicable way -\n" +
        "I will not scratch it out on purpose!) When petitioners used to come for\n" +
        "information to the table at which I sat, I used to grind my teeth at them,\n" +
        "and felt intense enjoyment when I succeeded in making anybody unhappy.\n" +
        "I almost did succeed. For the most part they were all timid people - of course,\n" +
        "they were petitioners. But of the uppish ones there was one officer in particular\n" + 
        "I could not endure. He simply would not be humble, and clanked his sword in a disgusting way.\n" +
        "I carried on a feud with him for eighteen months over that sword. At last I got the better of him.\n" +
        "He left off clanking it. That happened in my youth, though. But do you know,\n" +
        "gentlemen, what was the chief point about my spite? Why, the whole point,\n" +
        "the real sting of it lay in the fact that continually, even in the moment of the acutest spleen,\n" + 
        "I was inwardly conscious with shame that I was not only not a spiteful but not even an embittered man,\n" +
        "that I was simply scaring sparrows at random and amusing myself by it.\n" +
        "I might foam at the mouth, but bring me a doll to play with, give me a cup of tea with sugar in it,\n" +
        "and maybe I should be appeased. I might even be genuinely touched,\n" +
        "though probably I should grind my teeth at myself afterwards and lie awake at night with shame for\n" +
        "months after. That was my way. I was lying when I said just now that I was a spiteful official.\n" +
        "I was lying from spite. I was simply amusing myself with the petitioners and with the officer,\n" +
        "and in reality I never could become spiteful. I was conscious every moment in myself of many,\n" +
        "very many elements absolutely opposite to that. I felt them positively swarming in me,\n" +
        "these opposite elements." + 
        "I knew that they had been swarming in me all my life and craving some outlet from me,\n" +
        "but I would not let them, would not let them, purposely would not let them come out.\n" +
        "They tormented me till I was ashamed: they drove me to convulsions and - sickened me, at last,\n" +
        "how they sickened me!";
    
    private String largeTexts2 = 
        "Gentlemen, I am joking, and I know myself that my jokes are not brilliant\n" +
        ",but you know one can take everything as a joke." + 
        "I am, perhaps, jesting against the grain.\n" +
        "Gentlemen, I am tormented by questions; answer them for me." + 
        "You, for instance, want to cure men of their\n" + 
        "old habits and reform their will in accordance with science and good sense.\n" +
        "But how do you know, not only that it is possible, but also that it is\n" + 
        "desirable to reform man in that way?" +
        "And what leads you to the conclusion that man's\n" +
        "inclinations need reforming? In short," +
        "how do you know that such a reformation will be a benefit to man?\n" +
        "And to go to the root of the matter, why are you so positively convinced that not to act against\n" +
        "his real normal interests guaranteed by the conclusions of reason and arithmetic is certainly always\n" +
        "advantageous for man and must always be a law for mankind? So far, you know,\n" +
        "this is only your supposition." + 
        "It may be the law of logic, but not the law of humanity.\n" +
        "You think, gentlemen, perhaps that I am mad? Allow me to defend myself. I agree that man\n" +
        "is pre-eminently a creative animal," +
        "predestined to strive consciously for an object and to engage in engineering -\n" +
        "that is, incessantly and eternally to make new roads, wherever\n" +
        "they may lead. But the reason why he wants sometimes to go off at a tangent may just be that he is\n" +
        "predestined to make the road, and perhaps, too, that however stupid the \"direct\"\n" +
        "practical man may be, the thought sometimes will occur to him that the road almost always does lead\n" +
        "somewhere, and that the destination it leads to is less important than the process\n" +
        "of making it, and that the chief thing is to save the well-conducted child from despising engineering,\n" +
        "and so giving way to the fatal idleness, which, as we all know,\n" +
        "is the mother of all the vices. Man likes to make roads and to create, that is a fact beyond dispute.\n" +
        "But why has he such a passionate love for destruction and chaos also?\n" +
        "Tell me that! But on that point I want to say a couple of words myself." +
        "May it not be that he loves\n" +
        "chaos and destruction (there can be no disputing that he does sometimes love it)\n" +
        "because he is instinctively afraid of attaining his object and completing the edifice he is constructing?\n" +
        "Who knows, perhaps he only loves that edifice from a distance, and is by no means\n" +
        "in love with it at close quarters; perhaps he only loves building it and does not want to live in it,\n" +
        "but will leave it, when completed, for the use of les animaux domestiques -\n" +
        "such as the ants, the sheep, and so on. Now the ants have quite a different taste.\n" +
        "They have a marvellous edifice of that pattern which endures for ever - the ant-heap.\n" +
        "With the ant-heap the respectable race of ants began and with the ant-heap they will probably end,\n" +
        "which does the greatest credit to their perseverance and good sense. But man is a frivolous and\n" +
        "incongruous creature, and perhaps, like a chess player, loves the process of the game, not the end of it.\n" +
        "And who knows (there is no saying with certainty), perhaps the only goal on earth\n" +
        "to which mankind is striving lies in this incessant process of attaining, in other words,\n" +
        "in life itself, and not in the thing to be attained, which must always be expressed as a formula,\n" +
        "as positive as twice two makes four, and such positiveness is not life, gentlemen,\n" +
        "but is the beginning of death.";

    private String largeTexts3 = 
        "But these are all golden dreams. Oh, tell me, who was it first announced,\n" + 
        "who was it first proclaimed," +
        "that man only does nasty things because he does not know his own interests;\n" + 
        "and that if he were enlightened, if his eyes were opened to his real normal interests,\n" + 
        "man would at once cease to do nasty things, would at once become good and noble because,\n" + 
        "being enlightened and understanding his real advantage, he would see his own advantage in the\n" + 
        "good and nothing else, and we all know that not one man can, consciously, act against his own interests,\n" + 
        "consequently, so to say, through necessity, he would begin doing good? Oh, the babe! Oh, the pure,\n" + 
        "innocent child! Why, in the first place, when in all these thousands of years has there been a time\n" + 
        "when man has acted only from his own interest? What is to be done with the millions of facts that bear\n" + 
        "witness that men, consciously, that is fully understanding their real interests, have left them in the\n" + 
        "background and have rushed headlong on another path, to meet peril and danger,\n" + 
        "compelled to this course by nobody and by nothing, but, as it were, simply disliking the beaten track,\n" + 
        "and have obstinately, wilfully, struck out another difficult, absurd way," +
        "seeking it almost in the darkness.\n" + 
        "So, I suppose, this obstinacy and perversity were pleasanter to them than any advantage....\n" + 
        "Advantage! What is advantage?" +
        "And will you take it upon yourself to define with perfect accuracy in what the\n" + 
        "advantage of man consists? And what if it so happens that a man's advantage, sometimes, not only may,\n" + 
        "but even must,  consist in his desiring in certain cases what is harmful to himself and not advantageous.\n" + 
        "And if so, if there can be such a case, the whole principle falls into dust. What do you think -\n" + 
        "are there such cases? You laugh; laugh away, gentlemen, but only answer me: have man's advantages been\n" + 
        "reckoned up with perfect certainty? Are there not some which not only have not been included but cannot\n" + 
        "possibly be included under any classification? You see, you gentlemen have, to the best of my knowledge,\n" + 
        "taken your whole register of human advantages from the averages of statistical figures and\n" + 
        "politico-economical formulas." + 
        "Your advantages are prosperity, wealth, freedom, peace - and so on, and so on.\n" + 
        "So that the man who should, for instance," + 
        "go openly and knowingly in opposition to all that list would to your thinking,\n" + 
        "and indeed mine, too, of course, be an obscurantist or an absolute madman: would not he?" + 
        "But, you know, this is\n" + 
        "what is surprising: why does it so happen that all these statisticians," +
        "sages and lovers of humanity,\n" + 
        "when they reckon up human advantages invariably leave out one?" + 
        "They don't even take it into their reckoning\n" + 
        "in the form in which it should be taken, and the whole reckoning depends upon that." + 
        "It would be no greater matter,\n" + 
        "they would simply have to take it, this advantage, and add it to the list." +
        "But the trouble is, that this strange\n" + 
        "advantage does not fall under any classification and is not in place in any list." + 
        "I have a friend for instance ...\n" + 
        "Ech! gentlemen, but of course he is your friend, too; and indeed there is no one," + 
        "no one to whom he is not a friend!";

    private String largeTexts4 = 
        "Yes, but here I come to a stop! Gentlemen, you must excuse me for being over-philosophical;\n" + 
        "it's the result of forty years underground! Allow me to indulge my fancy." + 
        "You see, gentlemen, reason is an excellent thing,\n" + 
        "there's no disputing that," + 
        "but reason is nothing but reason and satisfies only the rational side of man's nature,\n" + 
        "while will is a manifestation of the whole life, that is," + 
        "of the whole human life including reason and all the impulses.\n" + 
        "And although our life, in this manifestation of it, is often worthless," +
        "yet it is life and not simply extracting square roots.\n" + 
        "Here I, for instance, quite naturally want to live, in order to satisfy all my capacities for life," + 
        "and not simply my capacity\n" + 
        "for reasoning, that is, not simply one twentieth of my capacity for life. What does reason know?" + 
        "Reason only knows what it has\n" + 
        "succeeded in learning (some things, perhaps, it will never learn;" + 
        "this is a poor comfort, but why not say so frankly?)\n" + 
        "and human nature acts as a whole, with everything that is in it," + 
        "consciously or unconsciously, and, even it if goes wrong, it lives.\n" + 
        "I suspect, gentlemen, that you are looking at me with compassion;" + 
        "you tell me again that an enlightened and developed man,\n" + 
        "such, in short, as the future man will be, cannot consciously desire anything disadvantageous to himself," + 
        "that that can be proved mathematically.\n" + 
        "I thoroughly agree, it can - by mathematics." + 
        "But I repeat for the hundredth time, there is one case, one only, when man may consciously, purposely,\n" + 
        "desire what is injurious to himself, what is stupid," + 
        "very stupid - simply in order to have the right to desire for himself even what is very stupid\n" + 
        "and not to be bound by an obligation to desire only what is sensible." + 
        "Of course, this very stupid thing, this caprice of ours, may be in reality,\n" + 
        "gentlemen, more advantageous for us than anything else on earth, especially in certain cases." + 
        "And in particular it may be more advantageous than\n" + 
        "any advantage even when it does us obvious harm," + 
        "and contradicts the soundest conclusions of our reason concerning our advantage -\n" + 
        "for in any circumstances it preserves for us what is most precious and most important - that is," + 
        "our personality, our individuality.\n" + 
        "Some, you see, maintain that this really is the most precious thing for mankind;" + 
        "choice can, of course, if it chooses, be in agreement\n" + 
        "with reason; and especially if this be not abused but kept within bounds." + 
        "It is profitable and some- times even praiseworthy.\n" +
        "But very often, and even most often," + 
        "choice is utterly and stubbornly opposed to reason ... and ... and ... do you know that that,\n" + 
        "too, is profitable, sometimes even praiseworthy? Gentlemen, let us suppose that man is not stupid." + 
        "(Indeed one cannot refuse to suppose that,\n" + 
        "if only from the one consideration, that, if man is stupid, then who is wise?)" + 
        "But if he is not stupid, he is monstrously ungrateful!\n" + 
        "Phenomenally ungrateful. In fact, I believe that the best definition of man is the ungrateful biped." + 
        "But that is not all, that is not his worst defect;\n" + 
        "his worst defect is his perpetual moral obliquity, perpetual" + 
        "- from the days of the Flood to the Schleswig-Holstein period.";

    @Test
    public void testNoTexts() {
        String[] input = {};
        Map<Character, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOneTextWithOneLetter() {
        String[] input = { "a" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('a', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOneTextWithMultipleLetters() {
        String[] input = { "bbcccd" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('b', 2);
                put('c', 3);
                put('d', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoTextsWithOneLetter() {
        String[] input = { "e", "f" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('e', 1);
                put('f', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoTextsWithMultipleLetters() {
        String[] input = { "ggh", "hhi" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('g', 2);
                put('h', 3);
                put('i', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testIgnoreLetterCasing() {
        String[] input = { "m", "M" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('m', 2);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testIgnoreWhitespace() {
        String[] input = { "   ", "\t", "\r\n" };
        Map<Character, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testIgnorePunctuation() {
        String[] input = { "!", "?", ";", ",", "." };
        Map<Character, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testIgnoreNumbers() {
        String[] input = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        Map<Character, Integer> expectedOutput = new HashMap<>();
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testUnicodeLetters() {
        String[] input = { "本", "φ", "ほ", "ø" };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('本', 1);
                put('φ', 1);
                put('ほ', 1);
                put('ø', 1);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCombinationOfLowerAndUppercaseLettersPunctuationAndWhiteSpace() {
        String[] input = { calculateFrecuencies };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('a',  32);
                put('b',  4);
                put('c',  6);
                put('d',  14);
                put('e',  37);
                put('f',  7);
                put('g',  8);
                put('h',  29);
                put('i',  19);
                put('k',  6);
                put('l',  12);
                put('m',  7);
                put('n',  19);
                put('o',  22);
                put('p',  7);
                put('r',  17);
                put('s',  16);
                put('t',  30);
                put('u',  9);
                put('v',  2);
                put('w',  9);
                put('y',  4);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testManySmallTexts() {
        String[] input = new String[50];
        Arrays.fill(input, "abbccc");
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('a', 50);
                put('b', 100);
                put('c', 150);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void testLargeTexts() {
        String[] input = { largeTexts1, largeTexts2, largeTexts3, largeTexts4 };
        Map<Character, Integer> expectedOutput = new HashMap<>() {
            {
                put('a',  845);
                put('b',  155);
                put('c',  278);
                put('d',  359);
                put('e',  1143);
                put('f',  222);
                put('g',  187);
                put('h',  507);
                put('i',  791);
                put('j', 12);
                put('k',  67);
                put('l',  423);
                put('m',  288);
                put('n',  833);
                put('o',  791);
                put('p',  197);
                put('q',  8);
                put('r',  432);
                put('s',  700);
                put('t',  1043);
                put('u',  325);
                put('v',  111);
                put('w',  223);
                put('x',  7);
                put('y',  251);
            }
        };
        ParallelLetterFrequency p = new ParallelLetterFrequency(input);

        assertThat(p.countLetters()).isEqualTo(expectedOutput);
    }    

}
