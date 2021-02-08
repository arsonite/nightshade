/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */



/*
class HEX {	
	static isHex = (color) => {
		return Array.isArray(color);
	};

	static toRGB = (color) => {
		let rgb = [];
		for (
			let i = 0, n = 3, col = color.replace('#', ''), multi = 2, bit = 16;
			i < n;
			i++
		) {
			rgb[i] = parseInt(col.substring(i * multi, i * multi + multi), bit);
		}
		return rgb;
	};

	static lighten = (color, factor) => {
		let tempRGB = HEX.toRGB(color);
		for (let i = 0; i < 3; i++) {
			tempRGB[i] += Math.floor(RGB_MAX * factor);
			if (tempRGB[i] > RGB_MAX) tempRGB[i] = RGB_MAX;
		}
		return RGB.toHEX(tempRGB);
	};

	static darken = (color, factor) => {
		let tempRGB = HEX.toRGB(color);
		for (let i = 0; i < 3; i++) {
			tempRGB[i] -= Math.floor(RGB_MAX * factor);
			if (tempRGB[i] < RGB_MIN) tempRGB[i] = RGB_MIN;
		}
		return RGB.toHEX(tempRGB);
	};

	static randomNoise = (color, noiseFactor) => {
		let tempRGB = HEX.toRGB(color);
		for (let i = 0, n = tempRGB.length; i < n; i++) {
			let col = tempRGB[i];
			let noise = noiseFactor * (Math.random() * noiseFactor);
			col += Math.floor(noise) + noiseFactor; // Makes sure that color-fragment is integer
			if (col < RGB_MIN) {
				col = RGB_MIN;
			} else if (col > RGB_MAX) {
				col = RGB_MAX;
			}
			tempRGB[i] = col;
		}
		return RGB.toHEX(tempRGB);
	};

	static mix = (colors) => {
		let arr = [0, 0, 0];
		colors.forEach((color) => {
			const tempRGB = HEX.toRGB(color);
			for (let i = 0, n = arr.length; i < n; i++) {
				arr[i] += tempRGB[i];
			}
		});
		for (let i = 0, n = arr.length; i < n; i++) {
			arr[i] = Math.floor(arr[i] / colors.length);
		}
		return RGB.toHEX(arr);
	};

	static random = () => {
		return RGB.toHEX(RGB.random());
	};
}
*/