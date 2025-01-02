/**
 * Generates a random string of the specified length.
 *
 * @param length - The length of the random string to generate.
 * @returns A random string consisting of uppercase letters, lowercase letters, and digits.
 */
export function randomByLength(length: number): string {
	let randomChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
	let result: string = ''
	for (let i = 0; i < length; i++) {
		result += randomChars.charAt(Math.floor(Math.random() * randomChars.length))
	}
	return result
}
