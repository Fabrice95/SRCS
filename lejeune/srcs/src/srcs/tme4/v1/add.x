struct operands {
	int operand1;
	int operand2;
};

program ADDITION {
	version ADDITION_V1 {
		int ADD(operands) = 0;
	} = 1;
} = 0x20000001;


