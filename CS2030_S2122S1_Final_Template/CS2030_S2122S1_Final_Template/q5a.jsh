LazyList<T> reverse() {
	if (this.isEmpty()) {
		return this;
	} else {
		this.tail().reverse().concat(LLmake(this.head(), this.makeEmpty()));
	}
}
	