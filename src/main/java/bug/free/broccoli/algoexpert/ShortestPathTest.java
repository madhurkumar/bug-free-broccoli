package bug.free.broccoli.algoexpert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ShortestPathTest {
    public static String shortenPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.replaceAll("//", "/").split("/");
        if (paths.length == 0) return path;
        boolean startWithBackSlash = paths[0].trim().length() == 0;
        for (String s : paths) {
            switch (s) {
                case "..":
                    if (!stack.isEmpty() && !"..".equals(stack.peek()))
                        stack.pop();
                    else stack.push(s);
                    break;
                case ".":
                    break;
                default:
                    if (s.trim().length() > 0)
                        stack.push(s);

            }
        }
        StringBuilder sb = startWithBackSlash ? new StringBuilder("/") : new StringBuilder();
        int i = 0;
        Iterator<String> s = stack.descendingIterator();
        boolean foundFirst = false;
        while (s.hasNext()) {
            String ss = s.next();
            i++;
            if (ss.equals("..") && startWithBackSlash && !foundFirst) continue;
            foundFirst = true;
            sb.append(ss);
            if (i < stack.size()) sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(shortenPath("/../../foo/bar/baz"));
        System.out.println(shortenPath("foo/bar/baz"));
        System.out.println(shortenPath("/../../foo/../../bar/baz"));
        assert ("../../../../../../../..".equals(shortenPath("../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../..")));
        System.out.println(shortenPath("../../foo/bar/baz"));
        System.out.println(shortenPath("../../foo/../../bar/baz"));
        System.out.println(shortenPath("/"));
    }
}
