
#include <algorithm>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

#include "timer.h"

std::vector<int> read_all_ints(const std::string& file_name)
{
	std::ifstream in_file{ file_name };
	std::vector<int> v;

	int n;
	while (in_file >> n)
		v.push_back(n);

	return v;
}

int count(int a[], size_t len)
{
	int count = 0;
	for (int i = 0; i < len; i++)
	{
//		int ai = a[i];
		for (int j = i + 1; j < len; j++)
		{
//			int aj = a[j];
			for (int k = j + 1; k < len; k++)
//				if (ai + aj + a[k] == 0)
				if (a[i] + a[j] + a[k] == 0)
					count++;
		}
	}
	return count;
}

int count(const std::vector<int> & a)
{
	size_t len = a.size();
	int count = 0;
	for (int i = 0; i < len; i++)
	{
//		int ai = a[i];
		for (int j = i + 1; j < len; j++)
		{
//			int aj = a[j];
			for (int k = j + 1; k < len; k++)
//				if (ai + aj + a[k] == 0)
				if (a[i] + a[j] + a[k] == 0)
					count++;
		}
	}
	return count;
}

int main(int argc, char * argv[])
{
	if (argc < 3)
	{
		std::cout << "Usage: three_sum <data> [array|vector|both]\n";
		return 0;
	}

	std::vector<int> v{ read_all_ints(argv[1]) };
	std::string test{ argv[2] };

	if (test == "array" || test == "both")
	{
		size_t len = v.size();
		int* a = new int[len];
		std::copy_n(std::begin(v), len, a);
		Timer t;
		int c = count(a, len);
		std::cout << "array: " << c << "  Time: " << t.elapsed() << '\n';
	}

	if (test == "vector" || test == "both")
	{
		Timer t;
		int c = count(v);
		std::cout << "vector: " << c << "  Time: " << t.elapsed() << '\n';
	}
}
