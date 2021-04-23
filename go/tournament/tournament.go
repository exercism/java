package tournament

import (
	"errors"
	"fmt"
	"io"
	"io/ioutil"
	"sort"
	"strings"
)

type LeaderBoard []TeamStats

type TeamStatsTable map[string]*TeamStats

type TeamStats struct {
	Name        string
	Wins        int
	Losses      int
	Draws       int
	GamesPlayed int
	Points      int
}


func Tally(r io.Reader, w io.Writer) error {
	data, err := ioutil.ReadAll(r)
	if err != nil {
		return err
	}

	teamScores, err := BuildTeamScores(string(data))
	if err != nil {
		return err
	}

	scoreboard := BuildScoreBoard(teamScores)

	err = PrintScoreBoard(w, scoreboard)
	if err != nil {
		return err
	}

	return nil
}


func BuildTeamScores(data string) (TeamStatsTable, error) {

	teamScores := make(TeamStatsTable)

	for _, line := range strings.Split(data, "\n") {
		split := strings.Split(line, ";")
		if len(split) == 1 {
			continue
		}

		if len(split) != 3 {
			return nil, fmt.Errorf("expecting 3 fields for line '%v'", line)
		}

		team1, team2, result := split[0], split[1], split[2]

		if _, ok := teamScores[team1]; !ok {
			teamScores[team1] = &TeamStats{Name: team1}
		}

		if _, ok := teamScores[team2]; !ok {
			teamScores[team2] = &TeamStats{Name: team2}
		}

		switch result {
		case "win":
			teamScores[team1].Wins++
			teamScores[team1].Points += 3
			teamScores[team2].Losses++
		case "loss":
			teamScores[team1].Losses++
			teamScores[team2].Wins++
			teamScores[team2].Points += 3
		case "draw":
			teamScores[team1].Draws++
			teamScores[team1].Points++
			teamScores[team2].Draws++
			teamScores[team2].Points++
		default:
			return nil, errors.New("unknown result")
		}
		teamScores[team1].GamesPlayed++
		teamScores[team2].GamesPlayed++
	}

	return teamScores, nil
}

func BuildScoreBoard(teamScores TeamStatsTable) []TeamStats {
	var scoreboard []TeamStats

	for _, v := range teamScores {
		scoreboard = append(scoreboard, *v)
	}

	sort.Slice(scoreboard, func(i, j int) bool {
		if scoreboard[i].Points == scoreboard[j].Points {
			return scoreboard[i].Name < scoreboard[j].Name
		}
		return scoreboard[i].Points > scoreboard[j].Points
	})

	return scoreboard
}

func PrintScoreBoard(w io.Writer, l LeaderBoard) error {
	var str strings.Builder

	str.WriteString("Team                           | MP |  W |  D |  L |  P\n")

	for _, entry := range l {
		_, err := str.WriteString(fmt.Sprintf("%-30s | %2d | %2d | %2d | %2d | %2d\n",
			entry.Name, entry.GamesPlayed, entry.Wins, entry.Draws, entry.Losses, entry.Points))
		if err != nil {
			return err
		}
	}

	_, err := w.Write([]byte(str.String()))
	if err != nil {
		return err
	}

	return nil
}

