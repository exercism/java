
class Words {
    count(phrase: string): Map<string, number> {
        let m = new Map();
        let words = phrase.trim().split(/\s+/g)

        words.forEach(function (w) {
            w = w.toLowerCase()
            if (m.has(w)) {
                m.set(w, m.get(w) + 1);
            } else {
                m.set(w, 1);
            }
        })
        return m;
    }
}

export default Words