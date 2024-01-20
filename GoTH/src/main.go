package main

import (
	"github.com/a-h/templ"
	"net/http"
)

var persons = []Person{{id: 1, name: "Alice"}, {id: 2, name: "Bob"}}

func EmployeesServer(w http.ResponseWriter, r *http.Request) {
	search := r.URL.Query().Get("search")
	templ.Handler(employees(persons, search)).ServeHTTP(w, r)
}

func main() {
	http.HandleFunc("/", EmployeesServer)
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		return
	}
}
