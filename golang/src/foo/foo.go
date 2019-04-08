package foo

import "fmt"


type Foo struct {
	intValue int
	strValue string
	listValue []int
}

func (foo *Foo) IntValue() int {
	return foo.intValue;
}

func (foo *Foo) StrValue() string {
	return foo.strValue;
}

func (foo *Foo) ListValue() []int {
	return foo.listValue;
}

func (foo *Foo) String() string {
	result := fmt.Sprintf("INT: %d\nSTRING: %s\nLIST: [", foo.intValue, foo.strValue)
	for i, num := range foo.listValue {
		if i > 0 {
			result += ", "
		}
		result += fmt.Sprintf("%d", num)
	}
	result += "]"
	return result
}

func New(i int, s string, l []int) Foo {
	return Foo{intValue: i, strValue: s, listValue: l}
}
