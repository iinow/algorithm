/**
 * 참조
 * @param beginWord
 * @param endWord
 * @param wordList
 * @returns
 */
const findLadders = function (
  beginWord: string,
  endWord: string,
  wordList: string[]
) {
  if (!wordList.includes(endWord)) return []

  const result: string[][] = [],
    map = new Map(),
    steps = new Map()

  for (const word of wordList) {
    for (let i = 0; i < word.length; i++) {
      const hash = word.substring(0, i) + '*' + word.substring(i + 1)

      if (!map.has(hash)) map.set(hash, [])

      map.get(hash).push(word)
      steps.set(hash, wordList.length)
    }
  }

  const queue = [[beginWord]]

  while (queue.length > 0) {
    const current = <string[]>queue.shift()
    if (!current) {
      return
    }

    const set = new Set(current) // for O(1) lookup time
    const lastWord = current[current.length - 1]
    if (lastWord === endWord) {
      if (result.length === 0 || current.length === result[0].length)
        result.push(current)
      else break // early stop because the current path takes longer
    } else {
      for (let i = 0; i < lastWord.length; i++) {
        const hash = lastWord.substring(0, i) + '*' + lastWord.substring(i + 1)
        if (!map.has(hash) || current.length > steps.get(hash)) continue

        for (const nextWord of map.get(hash))
          if (!set.has(nextWord))
            // don't want to go back to a word already in the path
            queue.push([...current, nextWord])

        steps.set(hash, current.length)
      }
    }
  }
  console.log(steps)
  return result
}

console.log(
  findLadders('qa', 'sq', [
    'si',
    'go',
    'se',
    'cm',
    'so',
    'ph',
    'mt',
    'db',
    'mb',
    'sb',
    'kr',
    'ln',
    'tm',
    'le',
    'av',
    'sm',
    'ar',
    'ci',
    'ca',
    'br',
    'ti',
    'ba',
    'to',
    'ra',
    'fa',
    'yo',
    'ow',
    'sn',
    'ya',
    'cr',
    'po',
    'fe',
    'ho',
    'ma',
    're',
    'or',
    'rn',
    'au',
    'ur',
    'rh',
    'sr',
    'tc',
    'lt',
    'lo',
    'as',
    'fr',
    'nb',
    'yb',
    'if',
    'pb',
    'ge',
    'th',
    'pm',
    'rb',
    'sh',
    'co',
    'ga',
    'li',
    'ha',
    'hz',
    'no',
    'bi',
    'di',
    'hi',
    'qa',
    'pi',
    'os',
    'uh',
    'wm',
    'an',
    'me',
    'mo',
    'na',
    'la',
    'st',
    'er',
    'sc',
    'ne',
    'mn',
    'mi',
    'am',
    'ex',
    'pt',
    'io',
    'be',
    'fm',
    'ta',
    'tb',
    'ni',
    'mr',
    'pa',
    'he',
    'lr',
    'sq',
    'ye',
  ])
)
