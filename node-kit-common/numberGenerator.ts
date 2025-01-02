/**
 * Generates a random integer between the specified `min` and `max` values,
 * excluding the specified `exclude` value.
 *
 * @param min - The minimum value (inclusive).
 * @param max - The maximum value (inclusive).
 * @param exclude - The value to exclude from the generated result.
 * @returns A random integer between `min` and `max`, excluding `exclude`.
 */
function randomBetween(min: number, max: number, exclude: number): number {
	const rand: number = Math.floor(Math.random() * (max - min + 1)) + min
	return rand === exclude ? randomBetween(min, max, exclude) : rand
}

export { randomBetween }
