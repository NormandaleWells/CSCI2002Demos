#pragma once

#include <chrono>

class Timer
{
private:
	using hrc = std::chrono::high_resolution_clock;
	using duration = std::chrono::duration<double>;
	hrc::time_point t0;
public:
	Timer() noexcept
	{
		t0 = hrc::now();
	}
	double elapsed() noexcept
	{
		hrc::time_point t1 = hrc::now();
		duration ts = std::chrono::duration_cast<duration>(t1 - t0);
		return ts.count();
	}
};
