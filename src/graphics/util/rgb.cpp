/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */



/*
class RGB {
	static toHEX = (arr) => {
		let color = '#';
		arr.forEach((value) => {
			value = value.toString(16);
			if (value.length === 1) value = '0' + value;
			color += value;
		});
		return color;
	};

	static interpolate = (a, b, t) => {
		let iter = 1 - t;
		return [
			iter * a[0] + t * b[0],
			iter * a[1] + t * b[1],
			iter * a[2] + t * b[2],
		];
	};

	static random = () => {
		return [
			Math.floor(Math.random() * RGB_MAX),
			Math.floor(Math.random() * RGB_MAX),
			Math.floor(Math.random() * RGB_MAX),
		];
	};
}
*/