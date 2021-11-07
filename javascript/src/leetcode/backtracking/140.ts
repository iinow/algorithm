function wordBreak(s: string, wordDict: string[]): string[] {
  const res: string[] = []

  const recursive = (
    sliceStr: string = s,
    copyWordDict: string[] = wordDict,
    values: string[] = []
  ) => {
    if (sliceStr.length === 0) {
      res.push(values.join(' '))
      return
    }

    for (let i = 0; i < copyWordDict.length; i++) {
      if (sliceStr.indexOf(copyWordDict[i]) === 0) {
        values.push(copyWordDict[i])
        recursive(
          sliceStr.substr(copyWordDict[i].length, sliceStr.length),
          copyWordDict,
          values
        )
        values.pop()
      }
    }
  }

  recursive()
  return res
}

;['pine apple pen apple']
console.log(
  wordBreak('pineapplepenapple', [
    'apple',
    'pen',
    'applepen',
    'pine',
    'pineapple',
  ])
)
