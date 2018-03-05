struct addition_infos {
	int operand1;
	int operand2;
	char* callback;
};

program ADDITION {
	version ADDITION_V1 {
		void ADD(addition_infos) = 0;
	} = 1;
} = 0x20000001;


