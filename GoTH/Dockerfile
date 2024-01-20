FROM golang:1.20-alpine as build

WORKDIR /api
COPY src/go.mod src/*.go ./
RUN go get -d -v ./...
RUN go install -v ./...
RUN go build

FROM golang:1.20-alpine

WORKDIR /api
COPY --from=build /api/api .

CMD ["./api"]