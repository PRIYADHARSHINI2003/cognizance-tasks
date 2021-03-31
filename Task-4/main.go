package main

import (
	"context"
	"fmt"
	"github.com/vartanbeno/go-reddit/v2/reddit"
	"log"
	"net/http"
)

var ctx = context.Background()

func main() {
	if err := run(); err != nil {
		log.Fatal(err)
	}
}

func run() (err error) {
// API 
	credentials := reddit.Credentials{
		ID:       "1234567890",
    Secret:   "!@#$%6&*()_",
		Username: "lll_Ad3674",
		Password: "**********",
	}
	client, _ := reddit.NewClient(credentials)

	if err != nil {
		print("Error : ", err)
		return
	}

	client.OnRequestCompleted(logResponse)

	// Searching for the subreddit r/memes
	_, _, err = reddit.DefaultClient().Subreddit.Search(ctx, "memes", nil)
	if err != nil {
		print("Error : ", err)
		return
	}

	// Top posts of last week
	posts, _, err := reddit.DefaultClient().Subreddit.TopPosts(ctx, "memes", &reddit.ListPostOptions{
		ListOptions: reddit.ListOptions{
			Limit: 10,
		},
		Time: "week",
	}
  
	if err != nil {
		print("Error : ", err)
		return
	}
	for _, post := range posts {
    
  // Upvoting posts
		_, err := client.Post.Upvote(ctx, post.ID)
		if err != nil {
			print("Error : ", err)
			return err
		}
	return
}

func logResponse(req *http.Request, res *http.Response) {
	fmt.Printf("%s %s %s\n", req.Method, req.URL, res.Status)
}
