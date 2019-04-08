package main

import (
	"api"
	"foo"
	"fmt"
	"reflect"
	"unsafe"
)


func goodConsumer(foo *foo.Foo) {
	// do nothing wrong with foo
}

func evilConsumer(foo *foo.Foo) {
	reflectValue := reflect.Indirect(reflect.ValueOf(foo))
	
    member := reflectValue.FieldByName("intValue")
	intPointer := unsafe.Pointer(member.UnsafeAddr())
    realIntPointer := (*int)(intPointer)
	*realIntPointer = 7
	
    member = reflectValue.FieldByName("strValue")
	strPointer := unsafe.Pointer(member.UnsafeAddr())
    realStrPointer := (*string)(strPointer)
    *realStrPointer = "James Bond"
}

func main() {
	apiInstance := api.New()
	goodConsumer(apiInstance.GetFoo())
	fmt.Println("*** After good consumer ***")
	fmt.Println(apiInstance.GetFoo().String())
	fmt.Println()

	apiInstance = api.New()
	evilConsumer(apiInstance.GetFoo())
	fmt.Println("*** After evil consumer ***")
	fmt.Println(apiInstance.GetFoo().String())
}