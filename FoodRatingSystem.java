public class FoodRatingSystem {

        // food -> cuisine
        private Map<String, String> foodToCuisine;
        // food -> rating
        private Map<String, Integer> foodToRating;
        // cuisine -> foods sorted by rating (desc) then lexicographically
        private Map<String, TreeSet<String>> cuisineToFoods;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodToCuisine = new HashMap<>();
            foodToRating = new HashMap<>();
            cuisineToFoods = new HashMap<>();

            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];

                foodToCuisine.put(food, cuisine);
                foodToRating.put(food, rating);

                cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(
                        (a, b) -> foodToRating.get(a).equals(foodToRating.get(b))
                                ? a.compareTo(b)
                                : foodToRating.get(b) - foodToRating.get(a)
                ));

                cuisineToFoods.get(cuisine).add(food);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodToCuisine.get(food);
            TreeSet<String> foodsSet = cuisineToFoods.get(cuisine);

            // remove old entry
            foodsSet.remove(food);
            // update rating
            foodToRating.put(food, newRating);
            // re-add with new rating
            foodsSet.add(food);
        }

        public String highestRated(String cuisine) {
            return cuisineToFoods.get(cuisine).first();
        }
    }
