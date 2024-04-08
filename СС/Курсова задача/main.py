import numpy as np
from scipy import signal
import matplotlib.pyplot as plt


amplitude = 1  # 1 волт
period = 10 * 2e-6  # 20 µs
duty_cycle = 1 / 3  # 33.3%
needed_harmonics_count = 5

frequency = round(1 / period)
sampling_rate = frequency * 2

# Подготвяне на сигнала
sample_times = np.linspace(start=0, stop=1, num=sampling_rate, endpoint=False)

signal = amplitude * signal.square(
    2 * np.pi * sample_times,
    duty=duty_cycle
)

plt.figure(figsize=(18, 7))

# Чертаене на сигнала
plt.subplot(1, 2, 1)
plt.plot(sample_times, signal)

# Означаване на осите
plt.xlabel('t [s]')
plt.ylabel('A [V]')
plt.title('S(t)')

# Форматиране за красота
plt.axhline(y=0, color='black')
plt.axvline(x=0, color='gray', linestyle='--')
plt.axvline(x=1, color='gray', linestyle='--')
plt.grid(True)

# Подготвяне на данните за АЧС
discrete_count = len(sample_times)
fourier_transform = np.fft.fft(signal) / discrete_count

spacing = sample_times[1] - sample_times[0]
frequencies = np.fft.fftfreq(discrete_count, d=spacing)

# Спектъра е симетричен, запазваме само едната страна
fourier_transform = fourier_transform[frequencies >= 0]
frequencies = frequencies[frequencies >= 0]

# Чертаене на АЧС
plt.subplot(1, 2, 2)
_, _, baseline = plt.stem(frequencies, np.abs(fourier_transform))

# Означаване на осите
plt.xlabel('ω [rad/s]')
plt.ylabel('A [V]')
plt.title('АЧС')

# Форматиране за красота
plt.setp(baseline, visible=False)
plt.axhline(y=0, color='black')
plt.xlim(-0.5, needed_harmonics_count + 0.5)
plt.grid(True)

# Показване на екрана
plt.show()
