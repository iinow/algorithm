function solution(new_id: string) {
  const regex = /[a-z\d-_\.]/
  let name = new_id
    .toLowerCase()
    .split('')
    .filter((v) => regex.test(v))
    .join('')
    .replace(/(\.+)/g, '.')
    .replace(/^(\.)/, '')
    .replace(/(\.)$/, '')

  if (name.length === 0) {
    name = 'a'
  }

  name = name.substr(0, 15).replace(/(\.)$/, '')

  if (name.length <= 2) {
    name += [...Array(3 - name.length)]
      .map(() => name[name.length - 1])
      .join('')
  }
  return name
}

console.log(solution('abcdefghijklmn.p'))
