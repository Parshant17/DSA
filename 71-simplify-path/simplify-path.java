class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String currentPath : paths) {
            if (currentPath.equals(".") || currentPath.trim().length() == 0) {
                continue;
            } else if (currentPath.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(currentPath);
            }
        }

        StringBuilder canonicalPath = new StringBuilder();
        for (String cpath : stack) {
            canonicalPath.append("/").append(cpath);
        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}
