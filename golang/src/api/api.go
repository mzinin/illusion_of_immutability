package api

import "foo"


type Api struct {
	foo foo.Foo
}

func (api *Api) GetFoo() *foo.Foo {
	return &api.foo
}

func New() Api {
	api := Api{}
	api.foo = foo.New(42, "Fish", []int{0, 1, 2, 3})
	return api
}
