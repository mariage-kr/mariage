const isBoolean = (value: string | null): boolean => {
  if (value === null) {
    return false;
  }
  const truthy: string[] = ['true', 'True', '1'];
  return truthy.includes(value);
};

export { isBoolean };
