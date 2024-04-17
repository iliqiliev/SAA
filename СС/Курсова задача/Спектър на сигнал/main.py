import numpy as np
from scipy import signal
import matplotlib.pyplot as plt


def main():
    harmonics_count = 5
    amplitude = 1  # 1 волт
    period = 10 * 2e-6  # 20 µs
    duty_cycle = 1 / 3 * period  # 33.3% от периода

    frequency = round(1 / period + 0.5)
    sampling_rate = frequency * 2

    # Подготвяне на сигнала
    sample_times = np.linspace(
        start=0,
        stop=period,
        num=sampling_rate,
        endpoint=False
    )

    square_wave = amplitude * signal.square(
        2 * np.pi * sample_times,
        duty=duty_cycle
    )

    # Дефиниране на прозореца, който показва графиките
    plt.figure("Курсова задача", figsize=(18, 7))
    plt.suptitle("Илия Илиев №111222012")

    # Чертаене на сигнала
    plt.subplot(1, 2, 1)
    plt.plot(sample_times, square_wave)

    # Означаване на осите
    plt.xlabel('t [s]')
    plt.ylabel('A [V]')
    plt.title('S(t)')

    # Форматиране за красота
    plt.axhline(y=0, color='black')
    plt.axvline(x=0, color='gray', linestyle='--')
    plt.axvline(x=period, color='gray', linestyle='--')
    plt.grid(True)

    # Подготвяне на данните за АЧС:
    discrete_count = len(sample_times)

    fourier_transform = np.fft.fft(square_wave) / discrete_count

    frequencies = np.fft.fftfreq(
        discrete_count,
        d=sample_times[1] - sample_times[0]
    )

    # Прилагаме маска за подобряване на бързодействието при чертаенето
    # Може да се закоментира за разглеждане на целия спектър
    mask = np.logical_and(
        frequencies >= 0,
        frequencies <= harmonics_count * frequency
    )

    fourier_transform = fourier_transform[mask]
    frequencies = frequencies[mask]

    # Чертаене на АЧС
    plt.subplot(1, 2, 2)
    _, _, baseline = plt.stem(frequencies, np.abs(fourier_transform))

    # Означаване на осите
    plt.xlabel('f [Hz]')
    plt.ylabel('A [V]')
    plt.title('АЧС')

    # Форматиране за красота
    padding = 0.2 * frequency
    plt.setp(baseline, visible=False)
    plt.axhline(y=0, color='black')
    plt.xlim(-padding, harmonics_count * frequency + padding)
    plt.grid(True)

    # Показване на екрана
    plt.show()


if __name__ == "__main__":
    main()
