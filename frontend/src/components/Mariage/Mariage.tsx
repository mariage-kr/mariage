interface PageProps {
  children: React.ReactNode;
}

function Mariage({ children }: PageProps) {
  const font: string = 'color:#9c94d0; font-size:11px;';
  console.log(
    "%c /'\\_/`\\                      __                                \
    \n/\\      \\      __      _ __  /\\_\\      __        __        __   \
    \n\\ \\ \\__\\ \\   /'__`\\   /\\`'__\\\\/\\ \\   /'__`\\    /'_ `\\    /'__`\\ \
    \n \\ \\ \\_/\\ \\ /\\ \\L\\.\\_ \\ \\ \\/  \\ \\ \\ /\\ \\L\\.\\_ /\\ \\L\\ \\  /\\  __/ \
    \n  \\ \\_\\\\ \\_\\\\ \\__/.\\_\\ \\ \\_\\   \\ \\_\\\\ \\__/.\\_\\\\ \\____ \\ \\ \\____\\\
    \n   \\/_/ \\/_/ \\/__/\\/_/  \\/_/    \\/_/ \\/__/\\/_/ \\/___L\\ \\ \\/____/\
    \n                                                 /\\____/        \
    \n                                                 \\_/__/         \
    \n\n\t\t\t   주류와 안주의 리뷰 커뮤니티, 마리아주입니다.",
    font,
  );
  return <>{children}</>;
}

export default Mariage;
