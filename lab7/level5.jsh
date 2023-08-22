Log<Integer> sum(int n) {
	int counter = 1;
	Log<Integer> base = Log.<Integer>of(0, "hit base case!");
	while (counter <= n) {
		int counter2 = counter;
		base = base.flatMap(x -> Log.<Integer>of(x + counter2, "adding " + counter2));
		counter += 1;
	}
	return base;	
}

Log<Integer> f(int n) {
	if (n == 1) {
		return Log.<Integer>of(1, "1");
	} else if (n % 2 == 0) {
		return Log.<Integer>of(n/2, n + " / " + 2).flatMap(x -> f(n/2));
	} else {
		return Log.<Integer>of(3 * n + 1, 3 + "(" + n + ") + "+ 1).flatMap(x -> f(3 * n + 1));
	}
}
